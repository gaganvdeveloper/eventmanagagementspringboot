package org.jsp.eventmanagement.entity;

import java.time.LocalDateTime;

import org.jsp.eventmanagement.util.EventStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private String organizer;
	private String chiefGuest;
	private LocalDateTime fromDateTime;
	private LocalDateTime toDateTime;
	@Enumerated(EnumType.STRING)
	private EventStatus status;
	@OneToOne
	private Profile profile;
}
