package com.app.ordenaly.security.utils;

import java.util.Arrays;
import java.util.List;

public enum Roles {
  ADMIN(Arrays.asList(
          Permissions.SAVE_PRODUCT,
          Permissions.READ_PRODUCTS,
          Permissions.DELETE_PRODUCT,
          Permissions.DELETE_USER,
          Permissions.SAVE_USER
  )),
  USER(Arrays.asList(
          Permissions.READ_PRODUCTS,
          Permissions.READ_TICKETS,
          Permissions.SAVE_TICKET,
          Permissions.SAVE_ORDER,
          Permissions.UPDATE_ORDER
  ));

  private List<Permissions> userPermissionList;
  Roles(List<Permissions> userPermissionList) {
    this.userPermissionList = userPermissionList;
  }
  public List<Permissions> getUserPermissionList() {
    return userPermissionList;
  }
  public void setUserPermissionList(List<Permissions> userPermissionList) {
    this.userPermissionList = userPermissionList;
  }

}
