package com.v_e.tliasteachingmanagementsystem.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "emp")
public class Emp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @Column(nullable = false,length = 10)
    private String empName;

    @Column(nullable = false,length = 2)
    private String gender;

    @Column
    private String image;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( referencedColumnName = "Id", nullable = false)
    @JsonIgnore
    private Dept empDept;

    @OneToMany(mappedBy = "emp", cascade = CascadeType.ALL)
    private List<Emp_Expr> empExpr;

    @Column(nullable = false, updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime empHireDate;

    @Column(nullable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private LocalDateTime empOperatedDate;
}
