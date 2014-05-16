/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package displays;

/**
 *
 * @author QUINTERO
 */
public class Subscriber_Locations {
    
    private int idsubscriber;
    private int idlocation;

    public Subscriber_Locations(int idsubscriber, int idlocation) {
        this.idsubscriber = idsubscriber;
        this.idlocation = idlocation;
    }

    public int getIdlocation() {
        return idlocation;
    }

    public void setIdlocation(int idlocation) {
        this.idlocation = idlocation;
    }

    public int getIdsubscriber() {
        return idsubscriber;
    }

    public void setIdsubscriber(int idsubscriber) {
        this.idsubscriber = idsubscriber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Subscriber_Locations other = (Subscriber_Locations) obj;
        if (this.idsubscriber != other.idsubscriber) {
            return false;
        }
        if (this.idlocation != other.idlocation) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.idsubscriber;
        hash = 29 * hash + this.idlocation;
        return hash;
    }
    
}
