package com.pluralsight.daos;

import com.pluralsight.models.Dealership;
import com.pluralsight.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public interface DealershipDAO {
    @Autowired
    DealershipDAO dealershipDAO = null;

    HashMap<Integer, Dealership> getAll();

    HashMap<Integer, Vehicle> getAllFromID(int id);
}
