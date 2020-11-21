# COMP3074 - Project 25
COMP3074 Mobile Development I Group Project repo.

### Create separate branches, never push to master branch directly. This will be done through pull requests and merging. 


TODO and proposed structuring: 


## SplashActivity 

  * Needs adjustment. In place and working otherwise. 

## MainActivity  

1. MainFragment
  * contains two Fragment containers for: 
2. SearchFragment
  * 1/4 top screen fragment for the search bar
    **if time permits we could look into making this a pull-down fragment that pushes the ListFragment down
    **and then can be pushed up again, letting the list expand a bit further up

3. ListFragment
  * 3/4 screen fragment for list (needs to be dynamic for searches)
  

## AboutActivity 

* in place, just need to edit names with full names and student numbers
* We can fancy it up a bit more later, low priority.


## DetailsActivity 

1. viewFragment
  * need at least dummy data or working edit fragment storing values locally for now 		
2. editFragment 
  * viewFragment copy with input instead of view only output.        
3. mapFragment 
  * partial fragment to show the small screen map. child fragment of/within viewFragment .... editFragment too? 
  * Maybe once a few fields[name/addy] are input, it switches to the location on the map. 
4. share modal/fragment
  * initially we mainly need the email choice here, if we have time, we can add 
	the other choices (twitter and fb) for the bonus marks later.

## MapActivity 

1. StaticMapFragment
  * just the map with the pointer 
2. DirectionsFragment
  * dynamic fullscreen directions. (similar principle as sensors output fragment from lt1)
  
  **flip between the two via the toggle and FragmentManager**
 



## BACKEND 

1. DB creation and data CRUD 
2. Input validation
3. Search/Filter entries 
4. Map Search 
5. Fragment view swap in directionsFragment (the most dynamic frag in the app, based on gps feed)
6. (Share screen) Email functionality 
7. (Share screen) Twitter and Facebook if time allows.
