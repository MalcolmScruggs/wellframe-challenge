package com.malcolmscruggs.wellframe;

/**
 * Created by mgscr on 10/3/2018.
 */
public class MedError extends Exception {

  String message;

  public MedError(String message) {
    this.message = message;
  }

  public String getMessage() {
    return this.message;
  }
}
