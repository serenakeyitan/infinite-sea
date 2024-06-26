// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.service;

import com.github.wubuku.sui.bean.EventId;
import com.github.wubuku.sui.bean.Page;
import com.github.wubuku.sui.bean.PaginatedMoveEvents;
import com.github.wubuku.sui.bean.SuiMoveEventEnvelope;
import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.dddml.suiinfinitesea.domain.roster.AbstractRosterEvent;
import org.dddml.suiinfinitesea.sui.contract.ContractConstants;
import org.dddml.suiinfinitesea.sui.contract.DomainBeanUtils;
import org.dddml.suiinfinitesea.sui.contract.SuiPackage;
import org.dddml.suiinfinitesea.sui.contract.roster.RosterCreated;
import org.dddml.suiinfinitesea.sui.contract.roster.RosterShipAdded;
import org.dddml.suiinfinitesea.sui.contract.roster.RosterSetSail;
import org.dddml.suiinfinitesea.sui.contract.roster.RosterLocationUpdated;
import org.dddml.suiinfinitesea.sui.contract.repository.RosterEventRepository;
import org.dddml.suiinfinitesea.sui.contract.repository.SuiPackageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RosterEventService {

    @Autowired
    private SuiPackageRepository suiPackageRepository;

    @Autowired
    private SuiJsonRpcClient suiJsonRpcClient;

    @Autowired
    private RosterEventRepository rosterEventRepository;

    @Transactional
    public void updateStatusToProcessed(AbstractRosterEvent event) {
        event.setEventStatus("D");
        rosterEventRepository.save(event);
    }

    @Transactional
    public void pullRosterCreatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getRosterCreatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<RosterCreated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ROSTER_MODULE_ROSTER_CREATED,
                    cursor, limit, false, RosterCreated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<RosterCreated> eventEnvelope : eventPage.getData()) {
                    saveRosterCreated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getRosterCreatedEventNextCursor() {
        AbstractRosterEvent lastEvent = rosterEventRepository.findFirstRosterCreatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveRosterCreated(SuiMoveEventEnvelope<RosterCreated> eventEnvelope) {
        AbstractRosterEvent.RosterCreated rosterCreated = DomainBeanUtils.toRosterCreated(eventEnvelope);
        if (rosterEventRepository.findById(rosterCreated.getRosterEventId()).isPresent()) {
            return;
        }
        rosterEventRepository.save(rosterCreated);
    }

    @Transactional
    public void pullRosterShipAddedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getRosterShipAddedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<RosterShipAdded> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ROSTER_MODULE_ROSTER_SHIP_ADDED,
                    cursor, limit, false, RosterShipAdded.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<RosterShipAdded> eventEnvelope : eventPage.getData()) {
                    saveRosterShipAdded(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getRosterShipAddedEventNextCursor() {
        AbstractRosterEvent lastEvent = rosterEventRepository.findFirstRosterShipAddedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveRosterShipAdded(SuiMoveEventEnvelope<RosterShipAdded> eventEnvelope) {
        AbstractRosterEvent.RosterShipAdded rosterShipAdded = DomainBeanUtils.toRosterShipAdded(eventEnvelope);
        if (rosterEventRepository.findById(rosterShipAdded.getRosterEventId()).isPresent()) {
            return;
        }
        rosterEventRepository.save(rosterShipAdded);
    }

    @Transactional
    public void pullRosterSetSailEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getRosterSetSailEventNextCursor();
        while (true) {
            PaginatedMoveEvents<RosterSetSail> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ROSTER_MODULE_ROSTER_SET_SAIL,
                    cursor, limit, false, RosterSetSail.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<RosterSetSail> eventEnvelope : eventPage.getData()) {
                    saveRosterSetSail(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getRosterSetSailEventNextCursor() {
        AbstractRosterEvent lastEvent = rosterEventRepository.findFirstRosterSetSailByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveRosterSetSail(SuiMoveEventEnvelope<RosterSetSail> eventEnvelope) {
        AbstractRosterEvent.RosterSetSail rosterSetSail = DomainBeanUtils.toRosterSetSail(eventEnvelope);
        if (rosterEventRepository.findById(rosterSetSail.getRosterEventId()).isPresent()) {
            return;
        }
        rosterEventRepository.save(rosterSetSail);
    }

    @Transactional
    public void pullRosterLocationUpdatedEvents() {
        String packageId = getDefaultSuiPackageId();
        if (packageId == null) {
            return;
        }
        int limit = 1;
        EventId cursor = getRosterLocationUpdatedEventNextCursor();
        while (true) {
            PaginatedMoveEvents<RosterLocationUpdated> eventPage = suiJsonRpcClient.queryMoveEvents(
                    packageId + "::" + ContractConstants.ROSTER_MODULE_ROSTER_LOCATION_UPDATED,
                    cursor, limit, false, RosterLocationUpdated.class);

            if (eventPage.getData() != null && !eventPage.getData().isEmpty()) {
                cursor = eventPage.getNextCursor();
                for (SuiMoveEventEnvelope<RosterLocationUpdated> eventEnvelope : eventPage.getData()) {
                    saveRosterLocationUpdated(eventEnvelope);
                }
            } else {
                break;
            }
            if (!Page.hasNextPage(eventPage)) {
                break;
            }
        }
    }

    private EventId getRosterLocationUpdatedEventNextCursor() {
        AbstractRosterEvent lastEvent = rosterEventRepository.findFirstRosterLocationUpdatedByOrderBySuiTimestampDesc();
        return lastEvent != null ? new EventId(lastEvent.getSuiTxDigest(), lastEvent.getSuiEventSeq() + "") : null;
    }

    private void saveRosterLocationUpdated(SuiMoveEventEnvelope<RosterLocationUpdated> eventEnvelope) {
        AbstractRosterEvent.RosterLocationUpdated rosterLocationUpdated = DomainBeanUtils.toRosterLocationUpdated(eventEnvelope);
        if (rosterEventRepository.findById(rosterLocationUpdated.getRosterEventId()).isPresent()) {
            return;
        }
        rosterEventRepository.save(rosterLocationUpdated);
    }


    private String getDefaultSuiPackageId() {
        return suiPackageRepository.findById(ContractConstants.DEFAULT_SUI_PACKAGE_NAME)
                .map(SuiPackage::getObjectId).orElse(null);
    }
}
