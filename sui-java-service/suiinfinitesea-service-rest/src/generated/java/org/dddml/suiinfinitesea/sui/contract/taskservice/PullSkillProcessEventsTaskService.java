// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.taskservice;

import org.dddml.suiinfinitesea.sui.contract.service.SkillProcessEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class PullSkillProcessEventsTaskService {

    @Autowired
    private SkillProcessEventService skillProcessEventService;

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.skill-process-created.fixed-delay:5000}")
    public void pullSkillProcessCreatedEvents() {
        skillProcessEventService.pullSkillProcessCreatedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.production-process-started.fixed-delay:5000}")
    public void pullProductionProcessStartedEvents() {
        skillProcessEventService.pullProductionProcessStartedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.production-process-completed.fixed-delay:5000}")
    public void pullProductionProcessCompletedEvents() {
        skillProcessEventService.pullProductionProcessCompletedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.ship-production-process-started.fixed-delay:5000}")
    public void pullShipProductionProcessStartedEvents() {
        skillProcessEventService.pullShipProductionProcessStartedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.ship-production-process-completed.fixed-delay:5000}")
    public void pullShipProductionProcessCompletedEvents() {
        skillProcessEventService.pullShipProductionProcessCompletedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.creation-process-started.fixed-delay:5000}")
    public void pullCreationProcessStartedEvents() {
        skillProcessEventService.pullCreationProcessStartedEvents();
    }

    @Scheduled(fixedDelayString = "${sui.contract.pull-skill-process-events.creation-process-completed.fixed-delay:5000}")
    public void pullCreationProcessCompletedEvents() {
        skillProcessEventService.pullCreationProcessCompletedEvents();
    }

}
