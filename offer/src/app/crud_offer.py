from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy import select
from . import models, schemas

async def create_offer(db: AsyncSession, offer_data: schemas.OfferCreate):
    offer = models.Offer(
        supplier_profile_id=offer_data.supplier_profile_id,
        title=offer_data.title,
        description=offer_data.description,
        status=offer_data.status,
        valid_until=offer_data.valid_until,
    )
    db.add(offer)
    await db.flush()  # gives offer.id for items

    for item in offer_data.items:
        db.add(models.OfferItem(
            offer_id=offer.id,
            product_id=item.product_id,
            product_name=item.product_name,
            available_quantity=item.available_quantity,
            unit_price=item.unit_price,
            unit=item.unit
        ))

    await db.commit()
    await db.refresh(offer)
    return offer

async def get_offers(db: AsyncSession):
    result = await db.execute(select(models.Offer))
    return result.scalars().all()
