package com.amir.levant.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "PARAMETER")
public class Parameter {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAMETER_generator")
    @SequenceGenerator(name = "PARAMETER_generator", sequenceName = "PARAMETER_SEQUENCE", allocationSize = 1)
    private Long id;

    @Column(name = "GROUP_ID")
    private Integer groupId;

    @Column(name = "GROUP_NAME")
    private String groupName;

    @Column(name = "GROUP_NAME_DESC")
    private String groupNameDesc;

    @Column(name = "CLUE")
    private String clue;

    @Column(name = "VALUE")
    private String value;

    @Column(name = "CREATE_DATE")
    private Date createDate;

    @Column(name = "LAST_EDIT_DATE")
    private Date lastEditDate;

}
