package com.jae.nightevent.dto;

import com.jae.nightevent.entities.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserEventDTO {

private int eventCreatorId;
private String eventName;
private String description;
}
