package com.system.management.library.aplikasi.book.management.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.system.management.library.aplikasi.book.management.model.response.BaseResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;


// menangani kasus ketika user sudah login tetapi tidak memiliki hak akses (role/permission) yang cukup untuk mengakses endpoint tertentu.
// HTTP 403 Forbidden
@Component
public class AccessDeniedConfig implements AccessDeniedHandler {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        response.setStatus(HttpServletResponse.SC_FORBIDDEN);
        response.setContentType("application/json");

        BaseResponse<?> errorResponse = BaseResponse.forbiddenAccess("You don’t have permission to access this resource");

        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}

