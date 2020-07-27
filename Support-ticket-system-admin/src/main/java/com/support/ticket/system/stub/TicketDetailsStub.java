package com.support.ticket.system.stub;

import com.support.ticket.system.model.CancelledReason;
import com.support.ticket.system.model.Status;
import com.support.ticket.system.model.TicketDetailsVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TicketDetailsStub {
    private static Map<Long, TicketDetailsVo> ticketdetails = new HashMap<Long, TicketDetailsVo>();
    private static Long idIndex = 3L;
    static {
        TicketDetailsVo a = new TicketDetailsVo(1L, "JOHN", "Adhoc ticket", 1, Status.CANCELLED, CancelledReason.ENDUSER, "cancelled", "Test");
        ticketdetails.put(1L, a);
        TicketDetailsVo b = new TicketDetailsVo(2L, "TOM", "Test bug", 0, Status.CANCELLED, CancelledReason.OTHER, "cancelled", "others");
        ticketdetails.put(2L, b);
        TicketDetailsVo c = new TicketDetailsVo(3L, "zim", "Production incident", 1, Status.COMPLETED, CancelledReason.ENDUSER, "cancelled", "others");
        ticketdetails.put(3L, c);
    }
    public static List<TicketDetailsVo> list() {
        return new ArrayList<>(ticketdetails.values());
    }
    public static TicketDetailsVo create(TicketDetailsVo wreck) {
       // idIndex += idIndex;
        final long newValue = ++idIndex;
        wreck.setId(newValue);
        ticketdetails.put(newValue, wreck);
        idIndex= newValue;
        return wreck;
    }
    public static TicketDetailsVo get(Long id) {
        return ticketdetails.get(id);
    }

    public static TicketDetailsVo update(Long id, TicketDetailsVo wreck) {
        ticketdetails.put(id, wreck);
        return wreck;
    }
    public static TicketDetailsVo delete(Long id) {
        return ticketdetails.remove(id);
    }
}
