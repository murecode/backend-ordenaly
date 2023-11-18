package com.app.ordenaly.utils;

import java.util.Arrays;
import java.util.List;

public enum Roles {
  ADMIN(Arrays.asList(
          Permissions.SAVE_A_PRODUCT,
          Permissions.RETRIEVE_ALL_PRODUCTS)),
  STAFF(Arrays.asList(
          Permissions.RETRIEVE_ALL_PRODUCTS));
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
