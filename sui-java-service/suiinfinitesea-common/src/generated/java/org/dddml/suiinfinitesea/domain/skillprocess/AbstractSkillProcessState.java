// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.domain.skillprocess;

import java.util.*;
import java.math.*;
import org.dddml.suiinfinitesea.domain.*;
import java.math.BigInteger;
import java.util.Date;
import org.dddml.suiinfinitesea.specialization.*;
import org.dddml.suiinfinitesea.domain.skillprocess.SkillProcessEvent.*;

public abstract class AbstractSkillProcessState implements SkillProcessState.SqlSkillProcessState {

    private SkillProcessId skillProcessId;

    public SkillProcessId getSkillProcessId() {
        return this.skillProcessId;
    }

    public void setSkillProcessId(SkillProcessId skillProcessId) {
        this.skillProcessId = skillProcessId;
    }

    private String id_;

    public String getId_() {
        return this.id_;
    }

    public void setId_(String id) {
        this.id_ = id;
    }

    private Long itemId;

    public Long getItemId() {
        return this.itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    private BigInteger startedAt;

    public BigInteger getStartedAt() {
        return this.startedAt;
    }

    public void setStartedAt(BigInteger startedAt) {
        this.startedAt = startedAt;
    }

    private BigInteger creationTime;

    public BigInteger getCreationTime() {
        return this.creationTime;
    }

    public void setCreationTime(BigInteger creationTime) {
        this.creationTime = creationTime;
    }

    private Boolean completed;

    public Boolean getCompleted() {
        return this.completed;
    }

    public void setCompleted(Boolean completed) {
        this.completed = completed;
    }

    private BigInteger endedAt;

    public BigInteger getEndedAt() {
        return this.endedAt;
    }

    public void setEndedAt(BigInteger endedAt) {
        this.endedAt = endedAt;
    }

    private java.math.BigInteger energyVault;

    public java.math.BigInteger getEnergyVault() {
        return this.energyVault;
    }

    public void setEnergyVault(java.math.BigInteger energyVault) {
        this.energyVault = energyVault;
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

    public AbstractSkillProcessState(List<Event> events) {
        initializeForReapplying();
        if (events != null && events.size() > 0) {
            this.setSkillProcessId(((SkillProcessEvent.SqlSkillProcessEvent) events.get(0)).getSkillProcessEventId().getSkillProcessId());
            for (Event e : events) {
                mutate(e);
                this.setOffChainVersion((this.getOffChainVersion() == null ? SkillProcessState.VERSION_NULL : this.getOffChainVersion()) + 1);
            }
        }
    }


    public AbstractSkillProcessState() {
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
        return getSkillProcessId().hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (obj instanceof SkillProcessState) {
            return Objects.equals(this.getSkillProcessId(), ((SkillProcessState)obj).getSkillProcessId());
        }
        return false;
    }


    public void mutate(Event e) {
        setStateReadOnly(false);
        if (false) { 
            ;
        } else if (e instanceof AbstractSkillProcessEvent.SkillProcessCreated) {
            when((AbstractSkillProcessEvent.SkillProcessCreated)e);
        } else if (e instanceof AbstractSkillProcessEvent.ProductionProcessCompleted) {
            when((AbstractSkillProcessEvent.ProductionProcessCompleted)e);
        } else if (e instanceof AbstractSkillProcessEvent.CreationProcessCompleted) {
            when((AbstractSkillProcessEvent.CreationProcessCompleted)e);
        } else {
            throw new UnsupportedOperationException(String.format("Unsupported event type: %1$s", e.getClass().getName()));
        }
    }

    public void merge(SkillProcessState s) {
        if (s == this) {
            return;
        }
        this.setItemId(s.getItemId());
        this.setStartedAt(s.getStartedAt());
        this.setCreationTime(s.getCreationTime());
        this.setCompleted(s.getCompleted());
        this.setEndedAt(s.getEndedAt());
        this.setEnergyVault(s.getEnergyVault());
        this.setVersion(s.getVersion());
        this.setActive(s.getActive());
    }

    public void when(AbstractSkillProcessEvent.SkillProcessCreated e) {
        throwOnWrongEvent(e);

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
        String status = e.getStatus();
        String Status = status;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        SkillProcessState updatedSkillProcessState = (SkillProcessState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CreateLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, status, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.skillprocess;
//
//public class CreateLogic {
//    public static SkillProcessState mutate(SkillProcessState skillProcessState, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String status, MutationContext<SkillProcessState, SkillProcessState.MutableSkillProcessState> mutationContext) {
//    }
//}

        if (this != updatedSkillProcessState) { merge(updatedSkillProcessState); } //else do nothing

    }

    public void when(AbstractSkillProcessEvent.ProductionProcessStarted e) {
        throwOnWrongEvent(e);

        Long itemId = e.getItemId();
        Long ItemId = itemId;
        BigInteger energyCost = e.getEnergyCost();
        BigInteger EnergyCost = energyCost;
        BigInteger startedAt = e.getStartedAt();
        BigInteger StartedAt = startedAt;
        BigInteger creationTime = e.getCreationTime();
        BigInteger CreationTime = creationTime;
        ItemIdQuantityPairs productionMaterials = e.getProductionMaterials();
        ItemIdQuantityPairs ProductionMaterials = productionMaterials;
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
        String status = e.getStatus();
        String Status = status;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        SkillProcessState updatedSkillProcessState = (SkillProcessState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.skillprocess.StartProductionLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, BigInteger.class, BigInteger.class, ItemIdQuantityPairs.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, itemId, energyCost, startedAt, creationTime, productionMaterials, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, status, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.skillprocess;
//
//public class StartProductionLogic {
//    public static SkillProcessState mutate(SkillProcessState skillProcessState, Long itemId, BigInteger energyCost, BigInteger startedAt, BigInteger creationTime, ItemIdQuantityPairs productionMaterials, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String status, MutationContext<SkillProcessState, SkillProcessState.MutableSkillProcessState> mutationContext) {
//    }
//}

        if (this != updatedSkillProcessState) { merge(updatedSkillProcessState); } //else do nothing

    }

    public void when(AbstractSkillProcessEvent.ProductionProcessCompleted e) {
        throwOnWrongEvent(e);

        Long itemId = e.getItemId();
        Long ItemId = itemId;
        BigInteger startedAt = e.getStartedAt();
        BigInteger StartedAt = startedAt;
        BigInteger creationTime = e.getCreationTime();
        BigInteger CreationTime = creationTime;
        BigInteger endedAt = e.getEndedAt();
        BigInteger EndedAt = endedAt;
        Boolean successful = e.getSuccessful();
        Boolean Successful = successful;
        Long quantity = e.getQuantity();
        Long Quantity = quantity;
        Long experience = e.getExperience();
        Long Experience = experience;
        Integer newLevel = e.getNewLevel();
        Integer NewLevel = newLevel;
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
        String status = e.getStatus();
        String Status = status;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        SkillProcessState updatedSkillProcessState = (SkillProcessState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteProductionLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, BigInteger.class, BigInteger.class, Boolean.class, Long.class, Long.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, itemId, startedAt, creationTime, endedAt, successful, quantity, experience, newLevel, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, status, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.skillprocess;
//
//public class CompleteProductionLogic {
//    public static SkillProcessState mutate(SkillProcessState skillProcessState, Long itemId, BigInteger startedAt, BigInteger creationTime, BigInteger endedAt, Boolean successful, Long quantity, Long experience, Integer newLevel, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String status, MutationContext<SkillProcessState, SkillProcessState.MutableSkillProcessState> mutationContext) {
//    }
//}

        if (this != updatedSkillProcessState) { merge(updatedSkillProcessState); } //else do nothing

    }

    public void when(AbstractSkillProcessEvent.CreationProcessStarted e) {
        throwOnWrongEvent(e);

        Long itemId = e.getItemId();
        Long ItemId = itemId;
        BigInteger energyCost = e.getEnergyCost();
        BigInteger EnergyCost = energyCost;
        Long resourceCost = e.getResourceCost();
        Long ResourceCost = resourceCost;
        BigInteger startedAt = e.getStartedAt();
        BigInteger StartedAt = startedAt;
        BigInteger creationTime = e.getCreationTime();
        BigInteger CreationTime = creationTime;
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
        String status = e.getStatus();
        String Status = status;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        SkillProcessState updatedSkillProcessState = (SkillProcessState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.skillprocess.StartCreationLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, Long.class, BigInteger.class, BigInteger.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, itemId, energyCost, resourceCost, startedAt, creationTime, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, status, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.skillprocess;
//
//public class StartCreationLogic {
//    public static SkillProcessState mutate(SkillProcessState skillProcessState, Long itemId, BigInteger energyCost, Long resourceCost, BigInteger startedAt, BigInteger creationTime, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String status, MutationContext<SkillProcessState, SkillProcessState.MutableSkillProcessState> mutationContext) {
//    }
//}

        if (this != updatedSkillProcessState) { merge(updatedSkillProcessState); } //else do nothing

    }

    public void when(AbstractSkillProcessEvent.CreationProcessCompleted e) {
        throwOnWrongEvent(e);

        Long itemId = e.getItemId();
        Long ItemId = itemId;
        BigInteger startedAt = e.getStartedAt();
        BigInteger StartedAt = startedAt;
        BigInteger creationTime = e.getCreationTime();
        BigInteger CreationTime = creationTime;
        BigInteger endedAt = e.getEndedAt();
        BigInteger EndedAt = endedAt;
        Boolean successful = e.getSuccessful();
        Boolean Successful = successful;
        Long quantity = e.getQuantity();
        Long Quantity = quantity;
        Long experience = e.getExperience();
        Long Experience = experience;
        Integer newLevel = e.getNewLevel();
        Integer NewLevel = newLevel;
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
        String status = e.getStatus();
        String Status = status;

        if (this.getCreatedBy() == null){
            this.setCreatedBy(e.getCreatedBy());
        }
        if (this.getCreatedAt() == null){
            this.setCreatedAt(e.getCreatedAt());
        }
        this.setUpdatedBy(e.getCreatedBy());
        this.setUpdatedAt(e.getCreatedAt());

        SkillProcessState updatedSkillProcessState = (SkillProcessState) ReflectUtils.invokeStaticMethod(
                    "org.dddml.suiinfinitesea.domain.skillprocess.CompleteCreationLogic",
                    "mutate",
                    new Class[]{SkillProcessState.class, Long.class, BigInteger.class, BigInteger.class, BigInteger.class, Boolean.class, Long.class, Long.class, Integer.class, Long.class, String.class, BigInteger.class, String.class, String.class, String.class, String.class, String.class, MutationContext.class},
                    new Object[]{this, itemId, startedAt, creationTime, endedAt, successful, quantity, experience, newLevel, suiTimestamp, suiTxDigest, suiEventSeq, suiPackageId, suiTransactionModule, suiSender, suiType, status, MutationContext.forEvent(e, s -> {if (s == this) {return this;} else {throw new UnsupportedOperationException();}})}
            );

//package org.dddml.suiinfinitesea.domain.skillprocess;
//
//public class CompleteCreationLogic {
//    public static SkillProcessState mutate(SkillProcessState skillProcessState, Long itemId, BigInteger startedAt, BigInteger creationTime, BigInteger endedAt, Boolean successful, Long quantity, Long experience, Integer newLevel, Long suiTimestamp, String suiTxDigest, BigInteger suiEventSeq, String suiPackageId, String suiTransactionModule, String suiSender, String suiType, String status, MutationContext<SkillProcessState, SkillProcessState.MutableSkillProcessState> mutationContext) {
//    }
//}

        if (this != updatedSkillProcessState) { merge(updatedSkillProcessState); } //else do nothing

    }

    public void save() {
    }

    protected void throwOnWrongEvent(SkillProcessEvent event) {
        SkillProcessId stateEntityId = this.getSkillProcessId(); // Aggregate Id
        SkillProcessId eventEntityId = ((SkillProcessEvent.SqlSkillProcessEvent)event).getSkillProcessEventId().getSkillProcessId(); // EntityBase.Aggregate.GetEventIdPropertyIdName();
        if (!stateEntityId.equals(eventEntityId)) {
            throw DomainError.named("mutateWrongEntity", "Entity Id %1$s in state but entity id %2$s in event", stateEntityId, eventEntityId);
        }


        Long stateVersion = this.getOffChainVersion();

    }


    public static class SimpleSkillProcessState extends AbstractSkillProcessState {

        public SimpleSkillProcessState() {
        }

        public SimpleSkillProcessState(List<Event> events) {
            super(events);
        }

        public static SimpleSkillProcessState newForReapplying() {
            SimpleSkillProcessState s = new SimpleSkillProcessState();
            s.initializeForReapplying();
            return s;
        }

    }



}

