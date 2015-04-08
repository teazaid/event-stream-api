package app

import _root_.infrastructure.{FrameworkRequest, FrameworkResponse}
import app.action.AppAction.Script
import app.entity.get.GetEntityController
import app.event.list.ListEventsController
import app.event.save.SaveEventController
import app.model.EntityId
import unfiltered.request.{Seg, GET, POST, Path}

object Routes {

  type AppRoutes = PartialFunction[FrameworkRequest, Script[FrameworkResponse]]

  def appRoutes: AppRoutes = {
    case req@POST(Path("/event")) => SaveEventController.save(req)
    case GET(Path("/event")) => ListEventsController.list
    case GET(Path(Seg("entity" :: entityId :: Nil))) => GetEntityController.get(EntityId(entityId))
  }

}
