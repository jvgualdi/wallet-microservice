package jvgualdi.tec.wallet.microservice.mapper;

import jvgualdi.tec.wallet.microservice.domain.Wallet;
import jvgualdi.tec.wallet.microservice.dto.WalletResponse;

public final class WalletMapper {

    private WalletMapper() {
    }

    public static WalletResponse toResponse(Wallet wallet) {
        return new WalletResponse(wallet.getCustomerId(), wallet.getBalance());
    }
}
