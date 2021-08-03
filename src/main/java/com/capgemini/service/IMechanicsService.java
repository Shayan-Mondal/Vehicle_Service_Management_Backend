package com.capgemini.service;

import java.util.List;

import com.capgemini.entities.Mechanics;

public interface IMechanicsService {
String createMechanics(Mechanics mechanics);
String updateMechanics(int mechanicsId,Mechanics mechanics);
Mechanics findMechanicsbyId(int mechanicsId);
List<Mechanics> getRequest();
String deleteMechanic(int mechanicsId);
}
