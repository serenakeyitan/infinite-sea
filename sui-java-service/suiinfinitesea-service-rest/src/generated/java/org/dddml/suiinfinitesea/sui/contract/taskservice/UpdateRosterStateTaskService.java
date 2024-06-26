// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.taskservice;

import org.dddml.suiinfinitesea.sui.contract.repository.*;
import org.dddml.suiinfinitesea.sui.contract.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpdateRosterStateTaskService {

    @Autowired
    private SuiRosterService suiRosterService;

    @Autowired
    private RosterEventRepository rosterEventRepository;

    @Autowired
    private RosterEventService rosterEventService;

    @Scheduled(fixedDelayString = "${sui.contract.update-roster-states.fixed-delay:5000}")
    @Transactional
    public void updateRosterStates() {
        rosterEventRepository.findByEventStatusIsNull().forEach(e -> {
            String objectId = e.getId_();
            suiRosterService.updateRosterState(objectId);
            rosterEventService.updateStatusToProcessed(e);
        });
    }
}
