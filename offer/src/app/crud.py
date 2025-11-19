from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy import select
from . import models, schemas

# Supplier
async def create_supplier(db: AsyncSession, supplier: schemas.SupplierProfileCreate):
    new_supplier = models.SupplierProfile(**supplier.dict())
    db.add(new_supplier)
    await db.commit()
    await db.refresh(new_supplier)
    return new_supplier

# Offer
async def create_offer(db: AsyncSession, offer: schemas.OfferCreate):
    new_offer = models.Offer(**offer.dict())
    db.add(new_offer)
    await db.commit()
    await db.refresh(new_offer)
    return new_offer

# OfferItem
async def create_offer_item(db: AsyncSession, item: schemas.OfferItemCreate):
    new_item = models.OfferItem(**item.dict())
    db.add(new_item)
    await db.commit()
    await db.refresh(new_item)
    return new_item

# Read
async def get_offers(db: AsyncSession):
    result = await db.execute(select(models.Offer))
    return result.scalars().all()

async def get_suppliers(db: AsyncSession):
    result = await db.execute(select(models.SupplierProfile))
    return result.scalars().all()

async def get_offer_items(db: AsyncSession):
    result = await db.execute(select(models.OfferItem))
    return result.scalars().all()
