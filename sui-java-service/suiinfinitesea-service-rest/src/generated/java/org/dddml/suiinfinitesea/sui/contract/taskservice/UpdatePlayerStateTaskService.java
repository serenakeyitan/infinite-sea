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
public class UpdatePlayerStateTaskService {

    @Autowired
    private SuiPlayerService suiPlayerService;

    @Autowired
    private PlayerEventRepository playerEventRepository;

    @Autowired
    private PlayerEventService playerEventService;

    @Scheduled(fixedDelayString = "${sui.contract.update-player-states.fixed-delay:5000}")
    @Transactional
    public void updatePlayerStates() {
        playerEventRepository.findByStatusIsNull().forEach(e -> {
            String objectId = e.getId();
            suiPlayerService.updatePlayerState(objectId);
            playerEventService.updateStatusToProcessed(e);
        });
    }
}