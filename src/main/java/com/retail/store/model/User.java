package com.retail.store.model;

import java.time.LocalDate;

/**
 * Represents a user of the retail store.
 */
public class User {

    private UserType userType;
    private LocalDate memberSince;

    /**
     * Constructs a user with specified user type and member since date.
     *
     * @param userType   The type of user (e.g., employee, affiliate, customer).
     * @param memberSince The date when the user became a member of the store.
     */
    public User(UserType userType, LocalDate memberSince) {
        this.userType = userType;
        this.memberSince = memberSince;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setMemberSince(LocalDate memberSince) {
        this.memberSince = memberSince;
    }

    public UserType getUserType() {
        return userType;
    }

    public LocalDate getMemberSince() {
        return memberSince;
    }


}

