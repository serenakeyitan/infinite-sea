#[allow(unused_variable, unused_use, unused_assignment, unused_mut_parameter)]
module infinite_sea::skill_process_complete_ship_production_logic {
    use std::option;

    use sui::clock;
    use sui::clock::Clock;
    use sui::tx_context::TxContext;
    use infinite_sea::player_aggregate;
    use infinite_sea_common::experience_table::ExperienceTable;
    use infinite_sea_common::item_id;
    use infinite_sea_common::item_production::{Self, ItemProduction};

    use infinite_sea::experience_table_util;
    use infinite_sea::player::{Self, Player};
    use infinite_sea::ship::Ship;
    use infinite_sea::ship_aggregate;
    use infinite_sea::skill_process;
    use infinite_sea::skill_process_util;

    friend infinite_sea::skill_process_aggregate;

    const EProcessNotStarted: u64 = 10;
    //const EInvalidPlayerId: u64 = 11;
    //const EIncorrectSkillType: u64 = 12;
    //const ENotEnoughEnergy: u64 = 13;
    const EStillInProgress: u64 = 14;
    //const EIncorrectItemId: u64 = 22;
    //const ELowerThanRequiredLevel: u64 = 24;
    //const ESenderHasNoPermission: u64 = 32;
    const EItemIdIsNotShip: u64 = 24;
    const EProcessFailed: u64 = 30;

    public(friend) fun verify(
        player: &mut Player,
        item_production: &ItemProduction,
        experience_table: &ExperienceTable,
        clock: &Clock,
        skill_process: &skill_process::SkillProcess,
        ctx: &TxContext,
    ): skill_process::ShipProductionProcessCompleted {
        let (player_id, skill_type, item_id) = skill_process_util::assert_ids_are_consistent_for_completing_production(
            player, item_production, skill_process
        );
        assert!(item_id != item_id::unused_item() && !skill_process::completed(skill_process), EProcessNotStarted);
        assert!(item_id::ship() == item_id, EItemIdIsNotShip);

        let started_at = skill_process::started_at(skill_process);
        let creation_time = skill_process::creation_time(skill_process);
        let ended_at = clock::timestamp_ms(clock) / 1000;
        assert!(ended_at >= started_at + creation_time, EStillInProgress);

        let successful = true; //todo
        let quantity = item_production::base_quantity(item_production);
        let added_experience = item_production::base_experience(item_production);
        let new_level = experience_table_util::calculate_new_level(player, experience_table, added_experience);
        skill_process::new_ship_production_process_completed(
            skill_process,
            item_id,
            started_at,
            creation_time,
            ended_at,
            successful,
            quantity,
            added_experience,
            new_level,
        )
    }

    public(friend) fun mutate(
        ship_production_process_completed: &skill_process::ShipProductionProcessCompleted,
        player: &mut Player,
        skill_process: &mut skill_process::SkillProcess,
        ctx: &mut TxContext, // modify the reference to mutable if needed
    ): Ship {
        let item_id = skill_process::ship_production_process_completed_item_id(ship_production_process_completed);
        //let started_at = skill_process::ship_production_process_completed_started_at(ship_production_process_completed);
        //let creation_time = skill_process::ship_production_process_completed_creation_time(ship_production_process_completed);
        let ended_at = skill_process::ship_production_process_completed_ended_at(ship_production_process_completed);
        let successful = skill_process::ship_production_process_completed_successful(ship_production_process_completed);
        let quantity = skill_process::ship_production_process_completed_quantity(ship_production_process_completed);
        let experience = skill_process::ship_production_process_completed_experience(ship_production_process_completed);
        let new_level = skill_process::ship_production_process_completed_new_level(ship_production_process_completed);
        //let skill_process_id = skill_process::skill_process_id(skill_process);

        skill_process::set_completed(skill_process, true);
        skill_process::set_ended_at(skill_process, ended_at);
        assert!(successful, EProcessFailed);
        let items = vector[];//vector[item_id_quantity_pair::new(item_id, quantity)];
        player_aggregate::increase_experience_and_items(player, experience, items, new_level, ctx);
        let building_expences = skill_process::production_materials(skill_process);
        assert!(option::is_some(&building_expences), EProcessNotStarted);
        let ship = ship_aggregate::create(player::id(player),
            100, //todo
            100, //todo
            100, //todo
            100, //todo
            option::extract(&mut building_expences),
            ctx,
        );
        ship
    }
}