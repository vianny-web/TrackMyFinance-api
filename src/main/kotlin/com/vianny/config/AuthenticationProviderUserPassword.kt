package com.vianny.config

import com.vianny.repositories.UserRepository
import io.micronaut.http.HttpRequest
import io.micronaut.security.authentication.AuthenticationFailureReason
import io.micronaut.security.authentication.AuthenticationRequest
import io.micronaut.security.authentication.AuthenticationResponse
import io.micronaut.security.authentication.provider.HttpRequestAuthenticationProvider
import jakarta.inject.Inject
import jakarta.inject.Singleton

@Singleton
class AuthenticationProviderUserPassword<B> : HttpRequestAuthenticationProvider<B> {

    @Inject
    private lateinit var userRepository: UserRepository

    override fun authenticate(
        httpRequest: HttpRequest<B>?,
        authenticationRequest: AuthenticationRequest<String, String>
    ): AuthenticationResponse {
        val userOptional = userRepository.findByLogin(authenticationRequest.identity)

        return if (authenticationRequest.identity == userOptional.get().login && authenticationRequest.secret == userOptional.get().password)
            AuthenticationResponse.success(authenticationRequest.identity) else
            AuthenticationResponse.failure(AuthenticationFailureReason.CREDENTIALS_DO_NOT_MATCH)
    }
}