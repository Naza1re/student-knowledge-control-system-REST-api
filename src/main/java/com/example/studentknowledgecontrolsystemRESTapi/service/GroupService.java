package com.example.studentknowledgecontrolsystemRESTapi.service;

import com.example.studentknowledgecontrolsystemRESTapi.exception.GroupNotFoundException;
import com.example.studentknowledgecontrolsystemRESTapi.model.Group;
import com.example.studentknowledgecontrolsystemRESTapi.model.Student;
import com.example.studentknowledgecontrolsystemRESTapi.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GroupService {

    private final GroupRepository groupRepository;
    @Autowired
    public GroupService(GroupRepository groupRepository) {
        this.groupRepository = groupRepository;
    }

    public ResponseEntity<Group> getGroupByName(String groupName) throws GroupNotFoundException {
        Optional<Group> opt_group = groupRepository.findByName(groupName);
        if(opt_group.isPresent()){
            return new ResponseEntity<>(opt_group.get(), HttpStatus.OK);
        }
        else throw new GroupNotFoundException("group with name '"+groupName+"' not found");
    }

    public HttpStatus deleteGroupByName(String groupName) throws GroupNotFoundException {

        Optional<Group> opt_group = groupRepository.findByName(groupName);
        if(opt_group.isPresent()){
            groupRepository.delete(opt_group.get());
            return HttpStatus.OK;
        }
        else throw new GroupNotFoundException("group with name '"+groupName+"' not found");

    }

    public ResponseEntity<List<Group>> getAllGroup() {
        List<Group> allGroup = groupRepository.getGroupsBy();
        return new ResponseEntity<>(allGroup,HttpStatus.OK);
    }

    public ResponseEntity<List<Student>> getStudentsOfGroup(String groupName) throws GroupNotFoundException {
        Optional<Group> opt_group = groupRepository.findByName(groupName);
        if(opt_group.isPresent()){

            List<Student> students = opt_group.get().getStudentList();
            return new ResponseEntity<>(students, HttpStatus.OK);
        }

        else throw new GroupNotFoundException("group with name '"+ groupName+ "' not found");
    }
}
