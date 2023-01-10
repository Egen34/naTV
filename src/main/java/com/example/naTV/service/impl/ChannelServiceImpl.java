package com.example.naTV.service.impl;

import com.example.naTV.exception.MicroServiceException;
import com.example.naTV.exception.Save4Exception;
import com.example.naTV.mapper.EntityAndDTO.ChannelMapper;
import com.example.naTV.microService.MicroService4Image;
import com.example.naTV.models.dto.ChannelDto;
import com.example.naTV.models.entity.Channel;
import com.example.naTV.models.entity.QChannel;
import com.example.naTV.models.repository.ChannelRepository;
import com.example.naTV.models.request.PriceRequest;
import com.example.naTV.models.response.GetChannalRespnonse;
import com.example.naTV.service.Interface.ChannelService;
import com.example.naTV.service.Interface.PriceService;
import com.example.naTV.utils.RBundle;
import com.querydsl.core.types.Predicate;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Date;
import java.util.List;
import java.util.Set;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ChannelServiceImpl extends BaseServiceImpl<Channel, QChannel, ChannelDto> implements ChannelService{
    private final ChannelRepository rep;
    private final MicroService4Image microService4Image;
    private final PriceService priceService;


    private final ChannelMapper mapper = ChannelMapper.INSTANCE;

    private ChannelServiceImpl(ChannelRepository rep, MicroService4Image microService4Image, PriceService priceService) {
        super(rep, ChannelMapper.INSTANCE);
        this.rep = rep;
        this.microService4Image = microService4Image;
        this.priceService = priceService;
    }


    @Override
    public List<ChannelDto> findAll(Predicate predicate, Pageable pageable) {
        return mapper.toListDTO(rep.findAll(predicate,pageable).getContent());
    }

    @Override
    public List<GetChannalRespnonse> getChannels(Pageable pageable) {
        return rep.findAlll(pageable).getContent();
    }


    @Override
    public ChannelDto save(String name, int orderNum, MultipartFile photo, Double price) throws Save4Exception, MicroServiceException {
        if (rep.existsByName(name))
            throw new Save4Exception(RBundle.SINGILTON.periodMessage("channelNameExist"));//TODO Нужно добавить текст в properties
        if (rep.existsByOrderNum(orderNum))
            throw new Save4Exception(RBundle.SINGILTON.periodMessage("orderNum"));//TODO Нужно добавить текст в properties
        ChannelDto dto = ChannelDto.builder().build();


        try {
            dto = super.save(ChannelDto.builder()
                    .name(name)
                    .orderNum(orderNum)
                    .photo(microService4Image.upload(photo).getDownloadUri())
                    .build());
        } catch (RuntimeException e) {
            throw new MicroServiceException(RBundle.SINGILTON.periodMessage("microserviceNotConnect"));
        }
        priceService.save(PriceRequest.builder()
                .startDate(new Date(System.currentTimeMillis()))
                .channelId(dto.getId())
                .price(price)
                .build()
        );
        return dto;
    }

}
