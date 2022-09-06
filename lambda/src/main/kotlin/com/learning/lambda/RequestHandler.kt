package com.learning.lambda

import com.learning.lambda.config.Logger
import io.micronaut.function.FunctionBean
import io.micronaut.function.aws.MicronautRequestHandler

@FunctionBean
class RequestHandler : MicronautRequestHandler<String, String>() {

    override fun execute(input: String): String {
        log.info("Received input: $input")
        return input
    }

    companion object : Logger()
}
