package com.ctu.Library.Log;

import com.ctu.Library.Reader.Reader;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity(name = "Log")
@Table(name = "action_reader")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "message", length = 100)
    private String message;
    @CreationTimestamp
    @Column(updatable = false, name = "created_at")
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "reader_id")
    private Reader reader;
}
