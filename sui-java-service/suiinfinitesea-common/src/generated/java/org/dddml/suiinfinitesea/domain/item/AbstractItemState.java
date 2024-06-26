// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.item;

import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.item.ItemEvent.*;

public abstract class AbstractItemState implements ItemState.SqlItemState {

    private Long itemId;

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    private String id_;

    public String getId_() {
        return this.id_;
    }

    public void setId_(String id) {
        this.id_ = id;
    }

    private String name;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Boolean requiredForCompletion;

    public Boolean getRequiredForCompletion() {
        return this.requiredForCompletion;
    }

    public void setRequiredForCompletion(Boolean requiredForCompletion) {
        this.requiredForCompletion = requiredForCompletion;
    }

    private Long sellsFor;

    public Long getSellsFor() {
        return this.sellsFor;
    }

    public void setSellsFor(Long sellsFor) {
        this.sellsFor = sellsFor;
    }

    private BigInteger version;

    public BigInteger getVersion() {
        return this.version;
    }

    public void setVersion(BigInteger version) {
        this.version = version;
    }

    private Long offChainVersion;

    public Long getOffChainVersion() {
        return this.offChainVersion;
    }

    public void setOffChainVersion(Long offChainVersion) {
        this.offChainVersion = offChainVersion;
    }

    private String createdBy;

    public String getCreatedBy() {
        return this.createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private Date createdAt;

    public Date getCreatedAt() {
        return this.createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    private String updatedBy;

    public String getUpdatedBy() {
        return this.updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    private Date updatedAt;

    public Date getUpdatedAt() {
        return this.updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    private Boolean active;

    public Boolean getActive() {
        return this.active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    private Boolean deleted;

    public Boolean getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public boolean isStateUnsaved() {
        return this.getOffChainVersion() == null;
    }

    private Boolean stateReadOnly;

    public Boolean getStateReadOnly() { return this.stateReadOnly; }

    public void setStateReadOnly(Boolean readOnly) { this.stateReadOnly = readOnly; }

    private boolean forReapplying;

    public boolean getForReapplying() {
        return forReapplying;
    }

    public void setForReapplying(boolean forReapplying) {
        this.forReapplying = forReapplying;
    }

    public AbstractItemState(List<Event> events) {
        initializeForReapplying();
        if (events != null && events.size() > 0) {
            this.setItemId(((ItemEvent.SqlItemEvent) events.get(0)).getItemEventId().getItemId());
            for (Event e : events) {
                mutate(e);
                this.setOffChainVersion((this.getOffChainVersion() == null ? ItemState.VERSION_NULL : this.getOffChainVersion()) + 1);
            }
        }
    }


    public AbstractItemState() {
        initializeProperties();
    }

    protected void initializeForReapplying() {
        this.forReapplying = true;

        initializeProperties();
    }
    
    protected void initializeProperties() {
    }

    @Override
    public int hashCode() {
        return getItemId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof ItemState) {
            return Objects.equals(this.getItemId(), ((ItemState)obj).getItemId());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else if (e instanceof AbstractItemEvent.ItemCreated) {
            when((AbstractItemEvent.ItemCreated)e);
        } else if (e instanceof AbstractItemEvent.ItemUpdated) {
            when((AbstractItemEvent.ItemUpdated)e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void merge(ItemState s) {
        if (s == this) {
            return;
        }
        this.setName(s.getName());
        this.setRequiredForCompletion(s.getRequiredForCompletion());
        this.setSellsFor(s.getSellsFor());
        this.setVersion(s.getVersion());
        this.setActive(s.getActive());
    }

    public void when(AbstractItemEvent.ItemCreated e) {
        throwOnWrongEvent(e);

        String name = e.getName();
        String Name = name;
        Boolean requiredForCompletion = e.getRequiredForCompletion();
        Boolean RequiredForCompletion = requiredForCompletion;
        Long sellsFor = e.getSellsFor();
        Long SellsFor = sellsFor;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        ItemState updatedItemState = (ItemState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.item.CreateLogic",
                    "mutate",
                    new Class[]{ItemState.class, String.class, Boolean.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, name, requiredForCompletion, sellsFor, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.item;
//
//public class CreateLogic {
//    public static ItemState mutate(ItemState itemState, String name, Boolean requiredForCompletion, Long sellsFor, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<ItemState, ItemState.MutableItemState> mutationContext) {
//    }
//}

        if (this != updatedItemState) { merge(updatedItemState); } //else do nothing

    }

    public void when(AbstractItemEvent.ItemUpdated e) {
        throwOnWrongEvent(e);

        String name = e.getName();
        String Name = name;
        Boolean requiredForCompletion = e.getRequiredForCompletion();
        Boolean RequiredForCompletion = requiredForCompletion;
        Long sellsFor = e.getSellsFor();
        Long SellsFor = sellsFor;
        Long suiTimestamp = e.getSuiTimestamp();
        Long SuiTimestamp = suiTimestamp;
        String suiTxDigest = e.getSuiTxDigest();
        String SuiTxDigest = suiTxDigest;
        BigInteger suiEventSeq = e.getSuiEventSeq();
        BigInteger SuiEventSeq = suiEventSeq;
        String suiPackageId = e.getSuiPackageId();
        String SuiPackageId = suiPackageId;
        String suiTransactionModule = e.getSuiTransactionModule();
        String SuiTransactionModule = suiTransactionModule;
        String suiSender = e.getSuiSender();
        String SuiSender = suiSender;
        String suiType = e.getSuiType();
        String SuiType = suiType;
        String eventStatus = e.getEventStatus();
        String EventStatus = eventStatus;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        ItemState updatedItemState = (ItemState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.item.UpdateLogic",
                    "mutate",
                    new Class[]{ItemState.class, String.class, Boolean.class, Long.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, name, requiredForCompletion, sellsFor, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, eventStatus, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.item;
//
//public class UpdateLogic {
//    public static ItemState mutate(ItemState itemState, String name, Boolean requiredForCompletion, Long sellsFor, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String eventStatus, MutationContext<ItemState, ItemState.MutableItemState> mutationContext) {
//    }
//}

        if (this != updatedItemState) { merge(updatedItemState); } //else do nothing

    }

    public void save() {
    }

    protected void throwOnWrongEvent(ItemEvent event) {
        Long stateEntityId = this.getItemId(); // Aggregate Id
        Long eventEntityId = ((ItemEvent.SqlItemEvent)event).getItemEventId().getItemId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }


        Long stateVersion = this.getOffChainVersion();

    }


    public static class SimpleItemState extends AbstractItemState {

        public SimpleItemState() {
        }

        public SimpleItemState(List<Event> events) {
            super(events);
        }

        public static SimpleItemState newForReapplying() {
            SimpleItemState s = new SimpleItemState();
            s.initializeForReapplying();
            return s;
        }

    }



}

