package com.github.leser.menu;


import com.github.leser.read.ConsoleReader;
import com.github.leser.repository.user.User;
import com.github.leser.repository.user.UserRepository;
import com.github.leser.sercive.DepositService;
import com.github.leser.sercive.WithdrawService;
import com.github.leser.util.Session;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import static com.github.leser.util.Constants.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class AccountMenu implements Menu{
private final ConsoleReader consoleReader;
private final Session session;
private final UserRepository userRepository;
private final DepositService depositService;
private final WithdrawService withdrawService;
    @Override
    public void enterMenu() {
        String input;
        String username = session.getUsername();
        User user = userRepository.findByUsername(username);
        do {
            System.out.println();
            System.out.println("Account menu, Hello " + username);
            System.out.println("Commands");
            System.out.println("balance - Check actual balance");
            System.out.println("deposit - Deposit");
            System.out.println("withdraw - Withdraw");
            System.out.println("logout - Logout");
            System.out.println("Choose one command from above");

            input = consoleReader.readInput();

            switch (input) {
                case ACCOUNT_MENU_BALANCE_OPTION:
                    System.out.println();
                    System.out.println("Your Balance is: "+ user.getBalance());
                    System.out.println();
                    break;
                case ACCOUNT_MENU_DEPOSIT_OPTION:
                    depositService.deposit(user);
                    break;
                case ACCOUNT_MENU_WITHDRAW_OPTION:
                    withdrawService.withdraw(user);
                    break;
                case ACCOUNT_MENU_LOGOUT_OPTION:
                    break;
                default:
                    System.err.println("Unknown command");
            }
        } while (!ACCOUNT_MENU_LOGOUT_OPTION.equals(input));
    }
}
