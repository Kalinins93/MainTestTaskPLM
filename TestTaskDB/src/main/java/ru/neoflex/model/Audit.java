package ru.neoflex.model;

import ru.neoflex.model.type.Action;
import ru.neoflex.model.type.objType;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlElement;

@Entity
@Table(name = "audit",schema="public")
public class Audit {
    @Id
    @Column(name = "object_id")
    private int object_id;
    @Id @Column(name = "object_type")
    private objType object_type;
    @Id @Column(name = "action_date")
    private Action action_date;
    @Id @Column(name = "action_id")
    private int action_id;
    @Id @Column(name = "new_value")
    private String new_value;
    @Id @Column(name = "audit_action")
    private XmlElement audit_action;
}
