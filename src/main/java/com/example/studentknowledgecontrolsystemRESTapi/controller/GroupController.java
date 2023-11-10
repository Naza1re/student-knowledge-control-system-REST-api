package com.example.studentknowledgecontrolsystemRESTapi.controller;

import com.example.studentknowledgecontrolsystemRESTapi.exception.GroupNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Group;
import com.example.studentknowledgecontrolsystemRESTapi.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/groups")
public class GroupController {

    private final GroupService groupService;
    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{group_name}")
    public ResponseEntity<Group> getGroupByName(@PathVariable String group_name) throws GroupNotFoundException {
        return groupService.getGroupByName(group_name);
    }
    @DeleteMapping("/{group_name}/delete")
    private HttpStatus deleteGroup(@PathVariable String group_name) throws GroupNotFoundException {
        return groupService.deleteGroupByName(group_name);
    }
    @GetMapping("/all-groups")
    private ResponseEntity<List<Group>> getAllGroup(){
        return groupService.getAllGroup();
    }

}
