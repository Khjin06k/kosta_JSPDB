package com.example.kosta_jspdb.service;

import com.example.kosta_jspdb.dao.AccountDAO;
import com.example.kosta_jspdb.dto.Account;
import com.example.kosta_jspdb.dto.Member;

import java.util.List;

public class AccountService {
    private AccountDAO dao = new AccountDAO();

    public void makeAccount(Account acc) throws Exception{
        Account sacc = dao.selectAccount(acc.getId());
        if(sacc != null) throw new Exception("계좌번호가 중복됩니다.");
        dao.insertAccount(acc);
    }

    // 계좌번호가 DB에 없는 경우 화면에 null이 표시되는 부분 해결 필요
    public Account accountInfo(String id, Member member) throws Exception{
        // id를 통해 계좌 불러오기
        Account acc = dao.selectAccount(id);
        System.out.println(acc.getId());
        // 자신의 계좌가 아닌 경우
        if(!member.getName().equals(acc.getName())) throw new Exception("회원의 계좌가 아니기에 조회 불가능합니다.");
        // 계좌가 없다면 존재하지 않을 경우
        if(acc == null) throw new Exception("계좌번호가 틀렸습니다.");

        // 계좌가 존재한다면 리턴
        return acc;
    }

    public Account accountDeposit(String id, Integer money, Member member) throws Exception {
        // id와 일치하는 계좌 가져오기
        Account acc = dao.selectAccount(id);
        if(acc == null) throw new Exception("계좌번호가 틀렸습니다.");
        // 내 계좌가 맞는지 확인하기
        if(!acc.getName().equals(member.getName())) throw new Exception("내 계좌가 아닙니다.");
        // 계좌가 존재하면 해당 계좌에 입금 진행
       acc.deposit(money);
       dao.changeMoney(acc); // DB에 입금액 반영
        return acc;
    }

    public Account accountWithdraw(String id, Integer money, Member member) throws Exception {
        // id와 일치하는 계좌 가져오기
        Account acc = dao.selectAccount(id);
        if(acc == null) throw new Exception("계좌번호가 틀렸습니다.");
        if(!acc.getName().equals(member.getName())) throw new Exception("내 계좌가 아닙니다.");
        // 계좌가 존재하면 해당 계좌에 입금 진행
        acc.withdraw(money);
        dao.changeMoney(acc); // DB에 출금액 반영
        return acc;
    }

    public List<Account> accountList() throws Exception{
        List<Account> accountList = dao.allAccount();

        if(accountList == null) throw new Exception("계설된 계좌가 없습니다.");

        return accountList;
    }
}
