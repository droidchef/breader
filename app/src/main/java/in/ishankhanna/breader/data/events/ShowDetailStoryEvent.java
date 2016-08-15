package in.ishankhanna.breader.data.events;

import in.ishankhanna.breader.data.models.Item;

/**
 * @author Ishan Khanna
 */
public class ShowDetailStoryEvent {

    private Item item;

    public ShowDetailStoryEvent(Item item) {
        this.item = item;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
