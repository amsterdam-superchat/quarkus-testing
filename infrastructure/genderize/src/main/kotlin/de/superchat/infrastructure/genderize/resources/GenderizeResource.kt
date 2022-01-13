package de.superchat.infrastructure.genderize.resources

import de.superchat.infrastructure.genderize.dto.GenderizeResponseDto
import io.smallrye.mutiny.Uni
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient
import org.jboss.resteasy.reactive.RestQuery
import javax.ws.rs.GET

@RegisterRestClient(configKey = "superchat.rest-client.genderize")
interface GenderizeResource {

    @GET
    fun get(
        @RestQuery name: String,
        @RestQuery countryId: String = "DE",
        @RestQuery apiKey: String? = null,
    ): Uni<GenderizeResponseDto>
}
