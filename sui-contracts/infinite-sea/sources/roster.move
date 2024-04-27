// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea::roster {
    use infinite_sea::ship::Ship;
    use infinite_sea_common::coordinates::Coordinates;
    use infinite_sea_common::roster_id::RosterId;
    use std::option::{Self, Option};
    use sui::event;
    use sui::object::{Self, ID, UID};
    use sui::object_table::ObjectTable;
    use sui::table;
    use sui::transfer;
    use sui::tx_context::TxContext;
    friend infinite_sea::roster_create_logic;
    friend infinite_sea::roster_add_ship_logic;
    friend infinite_sea::roster_set_sail_logic;
    friend infinite_sea::roster_aggregate;

    const EIdAlreadyExists: u64 = 101;
    #[allow(unused_const)]
    const EDataTooLong: u64 = 102;
    #[allow(unused_const)]
    const EInappropriateVersion: u64 = 103;
    const EEmptyObjectID: u64 = 107;

    struct RosterTable has key {
        id: UID,
        table: table::Table<RosterId, object::ID>,
    }

    struct RosterTableCreated has copy, drop {
        id: object::ID,
    }

    fun init(ctx: &mut TxContext) {
        let id_generator_table = RosterTable {
            id: object::new(ctx),
            table: table::new(ctx),
        };
        let id_generator_table_id = object::uid_to_inner(&id_generator_table.id);
        transfer::share_object(id_generator_table);
        event::emit(RosterTableCreated {
            id: id_generator_table_id,
        });
    }

    struct Roster has key {
        id: UID,
        roster_id: RosterId,
        version: u64,
        status: u8,
        speed: u32,
        ship_ids: vector<ID>,
        ships: ObjectTable<ID, Ship>,
        updated_coordinates: Coordinates,
        coordinates_updated_at: u64,
        target_coordinates: Option<Coordinates>,
        ship_battle_id: Option<ID>,
    }

    public fun id(roster: &Roster): object::ID {
        object::uid_to_inner(&roster.id)
    }

    public fun roster_id(roster: &Roster): RosterId {
        roster.roster_id
    }

    public fun version(roster: &Roster): u64 {
        roster.version
    }

    public fun status(roster: &Roster): u8 {
        roster.status
    }

    public(friend) fun set_status(roster: &mut Roster, status: u8) {
        roster.status = status;
    }

    public fun speed(roster: &Roster): u32 {
        roster.speed
    }

    public(friend) fun set_speed(roster: &mut Roster, speed: u32) {
        roster.speed = speed;
    }

    public fun borrow_ship_ids(roster: &Roster): &vector<ID> {
        &roster.ship_ids
    }

    public(friend) fun borrow_mut_ship_ids(roster: &mut Roster): &mut vector<ID> {
        &mut roster.ship_ids
    }

    public fun ship_ids(roster: &Roster): vector<ID> {
        roster.ship_ids
    }

    public(friend) fun set_ship_ids(roster: &mut Roster, ship_ids: vector<ID>) {
        roster.ship_ids = ship_ids;
    }

    public fun borrow_ships(roster: &Roster): &ObjectTable<ID, Ship> {
        &roster.ships
    }

    public(friend) fun borrow_mut_ships(roster: &mut Roster): &mut ObjectTable<ID, Ship> {
        &mut roster.ships
    }

    public fun updated_coordinates(roster: &Roster): Coordinates {
        roster.updated_coordinates
    }

    public(friend) fun set_updated_coordinates(roster: &mut Roster, updated_coordinates: Coordinates) {
        roster.updated_coordinates = updated_coordinates;
    }

    public fun coordinates_updated_at(roster: &Roster): u64 {
        roster.coordinates_updated_at
    }

    public(friend) fun set_coordinates_updated_at(roster: &mut Roster, coordinates_updated_at: u64) {
        roster.coordinates_updated_at = coordinates_updated_at;
    }

    public fun target_coordinates(roster: &Roster): Option<Coordinates> {
        roster.target_coordinates
    }

    public(friend) fun set_target_coordinates(roster: &mut Roster, target_coordinates: Option<Coordinates>) {
        roster.target_coordinates = target_coordinates;
    }

    public fun ship_battle_id(roster: &Roster): Option<ID> {
        roster.ship_battle_id
    }

    public(friend) fun set_ship_battle_id(roster: &mut Roster, ship_battle_id: Option<ID>) {
        roster.ship_battle_id = ship_battle_id;
    }

    fun new_roster(
        roster_id: RosterId,
        status: u8,
        speed: u32,
        ships: ObjectTable<ID, Ship>,
        updated_coordinates: Coordinates,
        coordinates_updated_at: u64,
        target_coordinates: Option<Coordinates>,
        ship_battle_id: Option<ID>,
        ctx: &mut TxContext,
    ): Roster {
        Roster {
            id: object::new(ctx),
            roster_id,
            version: 0,
            status,
            speed,
            ship_ids: std::vector::empty(),
            ships,
            updated_coordinates,
            coordinates_updated_at,
            target_coordinates,
            ship_battle_id,
        }
    }

    struct RosterCreated has copy, drop {
        id: option::Option<object::ID>,
        roster_id: RosterId,
        status: u8,
        speed: u32,
        updated_coordinates: Coordinates,
        coordinates_updated_at: u64,
        target_coordinates: Option<Coordinates>,
        ship_battle_id: Option<ID>,
    }

    public fun roster_created_id(roster_created: &RosterCreated): option::Option<object::ID> {
        roster_created.id
    }

    public(friend) fun set_roster_created_id(roster_created: &mut RosterCreated, id: object::ID) {
        roster_created.id = option::some(id);
    }

    public fun roster_created_roster_id(roster_created: &RosterCreated): RosterId {
        roster_created.roster_id
    }

    public fun roster_created_status(roster_created: &RosterCreated): u8 {
        roster_created.status
    }

    public fun roster_created_speed(roster_created: &RosterCreated): u32 {
        roster_created.speed
    }

    public fun roster_created_updated_coordinates(roster_created: &RosterCreated): Coordinates {
        roster_created.updated_coordinates
    }

    public fun roster_created_coordinates_updated_at(roster_created: &RosterCreated): u64 {
        roster_created.coordinates_updated_at
    }

    public fun roster_created_target_coordinates(roster_created: &RosterCreated): Option<Coordinates> {
        roster_created.target_coordinates
    }

    public(friend) fun set_roster_created_target_coordinates(roster_created: &mut RosterCreated, target_coordinates: Option<Coordinates>) {
        roster_created.target_coordinates = target_coordinates;
    }

    public fun roster_created_ship_battle_id(roster_created: &RosterCreated): Option<ID> {
        roster_created.ship_battle_id
    }

    public(friend) fun set_roster_created_ship_battle_id(roster_created: &mut RosterCreated, ship_battle_id: Option<ID>) {
        roster_created.ship_battle_id = ship_battle_id;
    }

    public(friend) fun new_roster_created(
        roster_id: RosterId,
        status: u8,
        speed: u32,
        updated_coordinates: Coordinates,
        coordinates_updated_at: u64,
        target_coordinates: Option<Coordinates>,
        ship_battle_id: Option<ID>,
    ): RosterCreated {
        RosterCreated {
            id: option::none(),
            roster_id,
            status,
            speed,
            updated_coordinates,
            coordinates_updated_at,
            target_coordinates,
            ship_battle_id,
        }
    }

    struct RosterShipAdded has copy, drop {
        id: object::ID,
        roster_id: RosterId,
        version: u64,
        position: Option<u64>,
    }

    public fun roster_ship_added_id(roster_ship_added: &RosterShipAdded): object::ID {
        roster_ship_added.id
    }

    public fun roster_ship_added_roster_id(roster_ship_added: &RosterShipAdded): RosterId {
        roster_ship_added.roster_id
    }

    public fun roster_ship_added_position(roster_ship_added: &RosterShipAdded): Option<u64> {
        roster_ship_added.position
    }

    public(friend) fun set_roster_ship_added_position(roster_ship_added: &mut RosterShipAdded, position: Option<u64>) {
        roster_ship_added.position = position;
    }

    public(friend) fun new_roster_ship_added(
        roster: &Roster,
        position: Option<u64>,
    ): RosterShipAdded {
        RosterShipAdded {
            id: id(roster),
            roster_id: roster_id(roster),
            version: version(roster),
            position,
        }
    }

    struct RosterSetSail has copy, drop {
        id: object::ID,
        roster_id: RosterId,
        version: u64,
        target_coordinates: Coordinates,
        set_sail_at: u64,
    }

    public fun roster_set_sail_id(roster_set_sail: &RosterSetSail): object::ID {
        roster_set_sail.id
    }

    public fun roster_set_sail_roster_id(roster_set_sail: &RosterSetSail): RosterId {
        roster_set_sail.roster_id
    }

    public fun roster_set_sail_target_coordinates(roster_set_sail: &RosterSetSail): Coordinates {
        roster_set_sail.target_coordinates
    }

    public fun roster_set_sail_set_sail_at(roster_set_sail: &RosterSetSail): u64 {
        roster_set_sail.set_sail_at
    }

    public(friend) fun new_roster_set_sail(
        roster: &Roster,
        target_coordinates: Coordinates,
        set_sail_at: u64,
    ): RosterSetSail {
        RosterSetSail {
            id: id(roster),
            roster_id: roster_id(roster),
            version: version(roster),
            target_coordinates,
            set_sail_at,
        }
    }


    public(friend) fun create_roster(
        roster_id: RosterId,
        status: u8,
        speed: u32,
        ships: ObjectTable<ID, Ship>,
        updated_coordinates: Coordinates,
        coordinates_updated_at: u64,
        target_coordinates: Option<Coordinates>,
        ship_battle_id: Option<ID>,
        roster_table: &mut RosterTable,
        ctx: &mut TxContext,
    ): Roster {
        let roster = new_roster(
            roster_id,
            status,
            speed,
            ships,
            updated_coordinates,
            coordinates_updated_at,
            target_coordinates,
            ship_battle_id,
            ctx,
        );
        asset_roster_id_not_exists_then_add(roster_id, roster_table, object::uid_to_inner(&roster.id));
        roster
    }

    public(friend) fun asset_roster_id_not_exists(
        roster_id: RosterId,
        roster_table: &RosterTable,
    ) {
        assert!(!table::contains(&roster_table.table, roster_id), EIdAlreadyExists);
    }

    fun asset_roster_id_not_exists_then_add(
        roster_id: RosterId,
        roster_table: &mut RosterTable,
        id: object::ID,
    ) {
        asset_roster_id_not_exists(roster_id, roster_table);
        table::add(&mut roster_table.table, roster_id, id);
    }

    #[lint_allow(share_owned)]
    public fun share_object(roster: Roster) {
        transfer::share_object(roster);
    }

    public(friend) fun update_object_version(roster: &mut Roster) {
        roster.version = roster.version + 1;
        //assert!(roster.version != 0, EInappropriateVersion);
    }

    public(friend) fun drop_roster(roster: Roster) {
        let Roster {
            id,
            roster_id: _roster_id,
            version: _version,
            status: _status,
            speed: _speed,
            ship_ids: _ship_ids,
            ships,
            updated_coordinates: _updated_coordinates,
            coordinates_updated_at: _coordinates_updated_at,
            target_coordinates: _target_coordinates,
            ship_battle_id: _ship_battle_id,
        } = roster;
        object::delete(id);
        sui::object_table::destroy_empty(ships);
    }

    public(friend) fun emit_roster_created(roster_created: RosterCreated) {
        assert!(std::option::is_some(&roster_created.id), EEmptyObjectID);
        event::emit(roster_created);
    }

    public(friend) fun emit_roster_ship_added(roster_ship_added: RosterShipAdded) {
        event::emit(roster_ship_added);
    }

    public(friend) fun emit_roster_set_sail(roster_set_sail: RosterSetSail) {
        event::emit(roster_set_sail);
    }

    #[test_only]
    /// Wrapper of module initializer for testing
    public fun test_init(ctx: &mut TxContext) {
        init(ctx)
    }

}
