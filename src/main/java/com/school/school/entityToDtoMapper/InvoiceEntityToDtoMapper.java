package com.school.school.entityToDtoMapper;

import com.school.school.dto.InvoiceDto;
import com.school.school.entity.Member;

public class InvoiceEntityToDtoMapper {

    public static InvoiceDto getInvoiceDto(Member member){
        InvoiceDto invoiceDto = new InvoiceDto();
        invoiceDto.setMemberStatus(member.getStatus());
        invoiceDto.setFirstName(member.getFirstName());
        invoiceDto.setLastName(member.getLastName());
        invoiceDto.setTitle(member.getTitle());
        invoiceDto.setEmail(member.getEmail());

        return invoiceDto;



    }


}
