package jvgualdi.tec.wallet.microservice.mapper;

import jvgualdi.tec.wallet.microservice.domain.Wallet;
import jvgualdi.tec.wallet.microservice.dto.WalletResponse;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface WalletMapper {

    WalletResponse toResponse(Wallet wallet);

}
