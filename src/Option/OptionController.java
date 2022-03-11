package Option;

import java.util.HashMap;

public class OptionController {

    public static HashMap<String, Option> getOptions() {
        HashMap<String, Option> options = new HashMap<String, Option>();

        options.put("allowLanding", new AllowLandingOpt());
        options.put("airRefueling", new AirRefuelingOpt());
        options.put("crossWinds", new CrossWindsOpt());
        options.put("emptyRandomRunway", new EmptyRandomRunwayOpt());
        options.put("getPoliceInvolved", new GetPoliceInvolvedOpt());
        options.put("iceStorm", new IceStormOpt());
        options.put("icyRunWays", new IcyRunWaysOpt());
        options.put("letTheManGo", new LetTheManGoOpt());
        options.put("letThemLand", new LetThemLandOpt());
        options.put("lockDownTheRunway", new LockdownTheRunwayOpt());
        options.put("placeOnStandby", new PlaceOnStandbyOpt());
        options.put("planesLandAnyways", new PlanesLandAnywaysOpt());
        options.put("refuseThe", new RefuseThemOpt());
        options.put("rescueTeam", new RescueTeamOpt());
        options.put("spaceToProtest", new SpaceToProtestOpt());

        return options;
    }
}
