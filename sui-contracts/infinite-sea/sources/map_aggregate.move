// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea::map_aggregate {
    use infinite_sea::map;
    use infinite_sea::map_add_island_logic;
    use infinite_sea_common::coordinates::{Self, Coordinates};
    use infinite_sea_common::item_id_quantity_pairs::{Self, ItemIdQuantityPairs};
    use sui::tx_context;

    friend infinite_sea::skill_process_service;

    const EInvalidAdminCap: u64 = 50;

    public entry fun add_island(
        map: &mut map::Map,
        admin_cap: &map::AdminCap,
        coordinates_x: u32,
        coordinates_y: u32,
        resources_item_id_list: vector<u32>,
        resources_item_quantity_list: vector<u32>,
        ctx: &mut tx_context::TxContext,
    ) {
        assert!(map::admin_cap(map) == sui::object::id(admin_cap), EInvalidAdminCap);
        map::assert_schema_version(map);
        let coordinates: Coordinates = coordinates::new(
            coordinates_x,
            coordinates_y,
        );
        let resources: ItemIdQuantityPairs = item_id_quantity_pairs::new(
            resources_item_id_list,
            resources_item_quantity_list,
        );
        let island_added = map_add_island_logic::verify(
            coordinates,
            resources,
            map,
            ctx,
        );
        map_add_island_logic::mutate(
            &island_added,
            map,
            ctx,
        );
        map::update_object_version(map);
        map::emit_island_added(island_added);
    }

}
