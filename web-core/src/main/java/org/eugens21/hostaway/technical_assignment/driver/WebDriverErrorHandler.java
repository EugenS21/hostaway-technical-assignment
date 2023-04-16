package org.eugens21.hostaway.technical_assignment.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.remote.ErrorHandler;
import org.openqa.selenium.remote.Response;

@Slf4j
public class WebDriverErrorHandler extends ErrorHandler {

    @Override
    public Response throwIfResponseFailed(Response response, long duration) throws RuntimeException {
        log.debug("Unexpected behavior of selenium");
        log.debug(response.toString());
        return new Response();
    }

}
