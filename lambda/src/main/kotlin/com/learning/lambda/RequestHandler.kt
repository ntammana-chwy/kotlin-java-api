package com.learning.lambda

import io.micronaut.function.aws.MicronautRequestHandler
import mu.KotlinLogging

class RequestHandler : MicronautRequestHandler<String, String>() {

    override fun execute(input: String): String {
        logger.info("Received input: $input")
        return input
    }

    private val logger = KotlinLogging.logger {}
}
