package com.app.ordenaly.utils;

import java.util.Arrays;
import java.util.List;

public enum Roles {
  ADMIN(Arrays.asList(
          Permissions.SAVE_PRODUCT,
          Permissions.READ_PRODUCTS,
          Permissions.DELETE_USER
  )),
  STAFF(Arrays.asList(
          Permissions.READ_PRODUCTS,
          Permissions.READ_ORDERS
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
