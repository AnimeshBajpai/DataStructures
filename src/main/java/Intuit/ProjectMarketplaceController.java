package Intuit;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/marketplace")
public class ProjectMarketplaceController {
    MarketPlace marketPlace = new MarketPlace();
    BiddingEngine biddingEngine = new BiddingEngine(marketPlace);


    @GET
    @Path("/init")
    public Response init() {//@PathParam("param") String msg

        return Response.status(200).build();
    }

    @POST
    @Path("/submitPro")
    public Response submit(Project project) {//@PathParam("param") String msg
        marketPlace.submitProject(project);
        return Response.status(200).build();
    }

}
