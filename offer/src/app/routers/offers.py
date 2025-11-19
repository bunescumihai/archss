from fastapi import APIRouter, Depends
from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy import select
from ..database import get_db
from .. import schemas, crud

router = APIRouter(prefix="/api/offers", tags=["offers"])

@router.post("/", response_model=schemas.OfferRead)
async def create_offer(offer: schemas.OfferCreate, db: AsyncSession = Depends(get_db)):
    return await crud.create_offer(db, offer)

@router.get("/", response_model=list[schemas.OfferRead])
async def list_offers(db: AsyncSession = Depends(get_db)):
    return await crud.get_offers(db)
