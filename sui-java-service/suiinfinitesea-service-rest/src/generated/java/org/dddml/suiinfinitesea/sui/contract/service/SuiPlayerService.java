// <autogenerated>
//   This file was generated by dddappp code generator.
//   Any changes made to this file manually will be lost next time the file is regenerated.
// </autogenerated>

package org.dddml.suiinfinitesea.sui.contract.service;

import com.github.wubuku.sui.utils.SuiJsonRpcClient;
import org.dddml.suiinfinitesea.domain.*;
import org.dddml.suiinfinitesea.domain.player.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.math.*;

@Service
public class SuiPlayerService {

    @Autowired
    private PlayerStateRepository playerStateRepository;

    private SuiPlayerStateRetriever suiPlayerStateRetriever;

    @Autowired
    public SuiPlayerService(SuiJsonRpcClient suiJsonRpcClient) {
        this.suiPlayerStateRetriever = new SuiPlayerStateRetriever(suiJsonRpcClient,
                id -> {
                    PlayerState.MutablePlayerState s = new AbstractPlayerState.SimplePlayerState();
                    s.setId(id);
                    return s;
                }
        );
    }

    @Transactional
    public void updatePlayerState(String objectId) {
        PlayerState playerState = suiPlayerStateRetriever.retrievePlayerState(objectId);
        if (playerState == null) {
            return;
        }
        playerStateRepository.merge(playerState);
    }

}

