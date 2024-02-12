package com.notebook.core.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Designation {

    INT("Internship"),
    SWD("Software Developer"),
    SWA("Software Architect"),
    TLE("Team Leader"),
    MNG("Manager"),
    DIR("Director");

    private final String title;
}
