package kr.co.junyoung.eatgo.interfaces;

import kr.co.junyoung.eatgo.application.MenuItemService;
import kr.co.junyoung.eatgo.application.RestaurantService;
import kr.co.junyoung.eatgo.domain.MenuItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MenuItemController {

    @Autowired
    private MenuItemService menuItemService;

    @GetMapping("/restaurants/{restaurantsId}/menuitems")
    public List<MenuItem> list(@PathVariable Long restaurantsId){
        List<MenuItem> menuItems = menuItemService.getMenuItems(restaurantsId);

        return menuItems;
    }


    @PatchMapping("/restaurants/{restaurantId}/menuitems")
    public String bulkUpdate(@PathVariable("restaurantId") Long restaurantId, @RequestBody List<MenuItem> menuItems ){

        menuItemService.bulkUpdate(restaurantId, menuItems);
        return "";
    }
}
