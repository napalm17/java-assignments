package kit.edu.informatik.u3.b2;

import kit.edu.informatik.u3.b2.EventRelated.Event;
import kit.edu.informatik.u3.b2.EventRelated.EventManagement;
import kit.edu.informatik.u3.b2.PersonRelated.Person;
import kit.edu.informatik.u3.b2.PersonRelated.PersonManagement;


public class EventAndPersonManagement {
    EventManagement eventManagement;
    PersonManagement personManagement;

    public EventAndPersonManagement(EventManagement e, PersonManagement p) {
        this.eventManagement = e;
        this.personManagement = p;
    }
    // B.2.7
    public String increaseSecurity (int eventId, int personId) {
        Event e = this.eventManagement.getEventfromId(eventId);
        if (canAddtoEvent(eventId, personId)) {
            e.addParticipant(personId);
            return "OK";
        }
        return "Could not add security";
    }
    // B.2.8
    public String bookSpot (int eventId, int personId) {
        Event e = this.eventManagement.getEventfromId(eventId);
        if (canAddtoEvent(eventId, personId)) {
            e.addParticipant(personId);
            return e.getRemaining() + " spot(s) left";
        }
        return "Could not book spot";
    }
    private boolean canAddtoEvent(int eventId, int personId) {
        Person p = this.personManagement.getPersonfromId(personId);
        Event e = this.eventManagement.getEventfromId(eventId);
        System.out.println(Utility.hasPermission(p.getProoftype(), p.getProofdate(), e.getDate(), e.is3G()));
        System.out.println(!(Utility.isInEvent(personId, e.getParticipants())));
        return Utility.hasPermission(p.getProoftype(), p.getProofdate(), e.getDate(), e.is3G())
                && e.getRemaining() > 0 && !(Utility.isInEvent(personId, e.getParticipants()));
    }
}
