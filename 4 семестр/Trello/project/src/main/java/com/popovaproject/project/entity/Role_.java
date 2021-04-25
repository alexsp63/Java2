package com.popovaproject.project.entity;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

public enum Role_ {
    USER(Set.of(Permission.TABLE_READ)),
    ADMIN(Set.of(Permission.TABLE_READ, Permission.TABLE_WRITE));

    private final Set<Permission> permissionSet;

    Role_(Set<Permission> permissionSet){
        this.permissionSet = permissionSet;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }



    public Set<SimpleGrantedAuthority> getAuthorities(){
        return getPermissionSet().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
