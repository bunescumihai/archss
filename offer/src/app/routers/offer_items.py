from fastapi import APIRouter, Depends
from sqlalchemy.ext.asyncio import AsyncSession
from ..database import get_db
from .. import schemas, crud

router = APIRouter(prefix="/api/offer-items", tags=["offer_items"])

@router.post("/", response_model=schemas.OfferItemRead)
async def create_offer_item(item: schemas.OfferItemCreate, db: AsyncSession = Depends(get_db)):
    return await crud.create_offer_item(db, item)

@router.get("/", response_model=list[schemas.OfferItemRead])
async def list_offer_items(db: AsyncSession = Depends(get_db)):
    return await crud.get_offer_items(db)
