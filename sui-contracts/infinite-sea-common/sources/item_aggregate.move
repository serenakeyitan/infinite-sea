// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

module infinite_sea_common::item_aggregate {
    use infinite_sea_common::item;
    use infinite_sea_common::item_create_logic;
    use infinite_sea_common::item_update_logic;
    use sui::tx_context;

    const EInvalidPublisher: u64 = 50;

    public entry fun create(
        item_id: u32,
        publisher: &sui::package::Publisher,
        name: std::ascii::String,
        required_for_completion: bool,
        sells_for: u32,
        item_table: &mut item::ItemTable,
        ctx: &mut tx_context::TxContext,
    ) {
        assert!(sui::package::from_package<item::Item>(publisher), EInvalidPublisher);
        let item_created = item_create_logic::verify(
            item_id,
            name,
            required_for_completion,
            sells_for,
            item_table,
            ctx,
        );
        let item = item_create_logic::mutate(
            &item_created,
            item_table,
            ctx,
        );
        item::set_item_created_id(&mut item_created, item::id(&item));
        item::share_object(item);
        item::emit_item_created(item_created);
    }

    public entry fun update(
        item: &mut item::Item,
        publisher: &sui::package::Publisher,
        name: std::ascii::String,
        required_for_completion: bool,
        sells_for: u32,
        ctx: &mut tx_context::TxContext,
    ) {
        assert!(sui::package::from_package<item::Item>(publisher), EInvalidPublisher);
        let item_updated = item_update_logic::verify(
            name,
            required_for_completion,
            sells_for,
            item,
            ctx,
        );
        item_update_logic::mutate(
            &item_updated,
            item,
            ctx,
        );
        item::update_object_version(item);
        item::emit_item_updated(item_updated);
    }

}
