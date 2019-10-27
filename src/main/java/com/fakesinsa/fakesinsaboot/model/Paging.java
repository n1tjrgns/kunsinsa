package com.fakesinsa.fakesinsaboot.model;

import lombok.Data;

@Data
public class Paging {
    private int pageCount = 5;
    private int start = 0;
    private int end = 0;
    private int lastPage = 0;

}
