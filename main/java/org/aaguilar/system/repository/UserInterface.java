package org.aaguilar.system.repository;

import org.aaguilar.system.model.User;

public interface UserInterface {
    void create(User usuario);
    void login(User usuario);
}
